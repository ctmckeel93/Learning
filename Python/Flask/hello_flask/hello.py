from flask import Flask, render_template 
from flask_bootstrap import Bootstrap

app = Flask(__name__)
Bootstrap(app)

@app.route('/')
def index():
    return render_template('index.html', phrase="goodbye", times=5)

@app.route('/dojo')
def success():
    return "Dojo"

@app.route('/hello/<name>')
def Hello(name):
    if name.isnumeric() == False:
        print(name)
        return "Hello, " + name.capitalize()
    else:
        return "The name must be a string"

@app.route('/repeat/<num>/<string>')
def Repeat(num, string ):
    if num.isnumeric() == True and string.isnumeric() == False:
        return (string + " ") * int(num)
    else:
        return "Invalid Params"

@app.errorhandler(404)
def page_not_found(error):
    return "Sorry! No response. Try Again!", 777


if __name__ == "__main__":
    app.run(debug=True)

