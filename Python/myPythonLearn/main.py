from myPythonLearn.Point import Point

def main():
    point1 = Point(1, 1)
    point2 = Point(3, 3)
    
    print(point1.calculate_distance(point2))

if __name__ == '__main__':
    main()