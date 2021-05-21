from flask import Flask, render_template, request, redirect

app = Flask(__name__)
@app.route('/')
def index():
    language_list = [
        "Python",
        "C#",
        "Ruby",
        "Javascript",
        "Java"
    ]
    return render_template('index.html', languages=language_list)

@app.route('/result', methods=['POST'])
def create_user():
    print(request.form)
    name = request.form['name']
    dojo = request.form['dojo']
    lang = request.form['language']
    frame = request.form['framework']
    css = request.form.getlist('css')
    return render_template('show.html', name_from_form=name, dojo_location=dojo, language=lang, framework=frame, css=css )


if __name__ == '__main__':
    app.run(debug=True)
