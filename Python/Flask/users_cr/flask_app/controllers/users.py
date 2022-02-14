from flask_app import app
from flask import render_template, request, redirect
from flask_app.models.user import User

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/all_users')
def all_users():
    users = User.get_all()
    return render_template('read_all.html', all_users=users)

@app.route('/add_user')
def add_user():
    return render_template('create.html')

@app.route('/create_user', methods=['POST'])
def create_user():
    data = {
        "first_name" : request.form["fname"],
        "lname" : request.form["lname"],
        "email" : request.form["email"],
    }
    User.save(data)
    return redirect('/all_users')

@app.route('/show_user/<int:id>')
def show_user(id):
    data = {
        "id" : id
    }
    user = User.get_one(data)
    return render_template('show.html', user=user)

@app.route('/edit_user/<int:id>')
def edit_user(id):
    data = {
        "id": id
    }
    user = User.get_one(data)
    return render_template('edit.html', user=user)

@app.route("/update_user", methods=["POST"])
def update_user():
    User.update(request.form)
    return redirect('/all_users')

@app.route('/delete_user/<int:id>')
def delete_user(id):
    data = {
        "id" : id
    }
    User.destroy(data)
    return redirect('/all_users')