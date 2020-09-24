def main():
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

    print("\nEffort = ", effort, "Person-Month")
    print("\nDevelopement Time = ", time, "Month")
    print("\nAverage Staff Required = ", fround(staff), "Persons")
    return
    
def fround(x):
    x = x + 0.5
    a = x
    return a

main()
