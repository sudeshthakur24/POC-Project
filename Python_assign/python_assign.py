from flask import Flask, request, jsonify, make_response
from flask_sqlalchemy import SQLAlchemy
from marshmallow import fields
from marshmallow_sqlalchemy import ModelSchema

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+pymysql://root:@localhost:5500/product'
db = SQLAlchemy(app)


class product(db.Model):
    __tablename__ = "products"
    id = db.Column(db.Integer, primary_key=True)
    product_name = db.Column(db.String(20))
    product_description = db.Column(db.String(100))

    def create(self):
        db.session.add(self)
        db.session.commit()
        return self

    def __init__(self, product_name, product_description):
        self.product_name = product_name
        self.product_description = product_description

    def __repr__(self):
        return f"{self.id}"


db.create_all()


class productSchema(ModelSchema):
    class Meta(ModelSchema.Meta):
        model = product
        sqla_session = db.session

    id = fields.Number(dump_only=True)
    product_name = fields.String(required=True)
    product_description = fields.String(required=True)


@app.route('/api/v1/product', methods=['POST'])
def create_product():
    data = request.get_json()
    product_schema = productSchema()
    product = product_schema.load(data)
    result = product_schema.dump(product.create())
    return make_response(jsonify({"product": result}), 200)


@app.route('/api/v1/product', methods=['GET'])
def index():
    get_products = product.query.all()
    product_schema = productSchema(many=True)
    products = product_schema.dump(get_products)
    return make_response(jsonify({"products": products}))


@app.route('/api/v1/product/<id>', methods=['PUT'])
def update_product_by_id(id, product=None):
    data = request.get_json()
    get_product = product.query.get(id)
    if data.get('product_name'):
        get_product.product_name = data['product_name']
    if data.get('product_description'):
        get_product.product_description = data['product_description']
    db.session.add(get_product)
    db.session.commit()
    product_schema = productSchema(only=['id', 'product_name', 'product_description'])
    product = product_schema.dump(get_product)

    return make_response(jsonify({"product": product}))


@app.route('/api/v1/product/<id>', methods=['DELETE'])
def delete_product_by_id(id):
    get_product = product.query.get(id)
    db.session.delete(get_product)
    db.session.commit()
    return make_response("", 204)
