from flask import Flask
# If `entrypoint` is not defined in app.yaml, App Engine will look for an app
# called `app` in `main.py`.
app = Flask(__name__)
@app.route('/')

def cocomo():
    table = [[2.4,1.05,2.5,0.38],[3.0,1.12,2.5,0.35],[3.6,1.20,2.5,0.32]]
    mode = ["Organic","Semi-Detached","Embedded"]
    size = 4
    calculate(table, 3, mode, size)
    return 0

def calculate(table, n, mode, size):
    if(size >= 2 and size <= 50):
        model = 0
    elif(size >= 50 and size <= 300):
        model = 1
    elif(size > 300):
        model = 2
        
    print("The mode is ", mode[model])
    
    effort = table[model][0] * size ** table[model][1]
    time = table[model][2] * effort ** table[model][3]
    staff = effort / time

    print("Effort = ", round(effort,4), "Person-Month")
    print("Developement Time = ", round(time,6), "Month")
    print("Average Staff Required = ", round(fround(staff)), "Persons")
    return
    
def fround(x):
    x = x + 0.5
    a = x
    return a

if __name__ == '__main__':
    # This is used when running locally only. When deploying to Google App
    # Engine, a webserver process such as Gunicorn will serve the app. This
    # can be configured by adding an `entrypoint` to app.yaml.
    app.run(host='127.0.0.1', port=8080, debug=True)
