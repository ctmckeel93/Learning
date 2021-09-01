from flask import Flask, render_template, request, session, redirect
import random


app = Flask(__name__)
app.secret_key = "secret"
@app.route('/')
def index():
    rng = random.randint(1,100)
    if "magic" not in session:
        session['magic'] = rng
    print(type(rng))
    return render_template('index.html')

@app.route('/result', methods=['POST'])
def result():
    session['guess'] = int(request.form['guess'])
    print(type(session['guess']))
    return redirect('/')

@app.route('/reset')
def reset():
    session.clear()
    return redirect('/')


if __name__ == '__main__':
    app.run(debug=True)