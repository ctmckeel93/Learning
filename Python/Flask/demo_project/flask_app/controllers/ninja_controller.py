from flask_app import app
from flask import Flask, render_template, request, redirect
from flask_app.models.Ninja import Ninja

@app.route('/all_ninjas')
def all_ninjas():
    ninjas = Ninja.get_all()
    return render_template('index.html', all_ninjas=ninjas) 

@app.route('/new_ninja')
def new_ninja():
    return render_template('create.html')

@app.route('/create_ninja', methods=['POST'])
def create_ninja():
    data = {
        "name" : request.form['name']
    }
    Ninja.save(data)
    return redirect('/all_ninjas')

