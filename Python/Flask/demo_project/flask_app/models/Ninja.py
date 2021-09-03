from flask_app.config.mysqlconnection import connectToMySQL

class Ninja:
    def __init__(self, data):
        self.name = data['name']

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM ninjas"
        results = connectToMySQL('demo').query_db(query)
        ninjas = []

        for ninja in results:
            ninjas.append(cls(ninja))
        return ninjas

    @classmethod
    def save(cls, data):
        query = "INSERT INTO ninjas (name) VALUES (%(name)s);"
        return connectToMySQL('demo').query_db(query, data)
