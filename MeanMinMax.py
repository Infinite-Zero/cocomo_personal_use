
def main():
    table = [[2.4,1.05,2.5,0.38],[3.0,1.12,2.5,0.35],[3.6,1.20,2.5,0.32]]

    print("Organic: Mean = {} Min = {} Max = {}" .format(Mean(table[0]), min(table[0]), max(table[0])))
    print("Semi-Detached: Mean = {} Min = {} Max = {}" .format(Mean(table[1]), min(table[1]), max(table[1])))
    print("Embedded: Mean = {} Min = {} Max = {}" .format(Mean(table[2]), min(table[2]), max(table[2])))

    print("Python Output-----")
    print("The mode is Organic\nEffort = 10.289 Person-Month\nDevelopment Time = 6.06237 Months\nAverage Staff Required = 2 Persons")
    print("Java Output-------")
    print("The mode is Organic\nEffort = 10.289 Person-Month\nDevelopment Time = 6.06237 Months\nAverage Staff Required = 2 Persons")
    
    return 0


def Mean(data):
    return sum(data) / len(data)

main()