//
//  main.swift
//  OOP
//
//  Created by Corey Mckeel on 6/2/21.
//

import Foundation

struct Point {
    var x: Double
    var y: Double
}

struct Line {
    var start: Point
    var end: Point
    var length: Double = 0.0
    init (start: Point, end: Point){
        self.start = start
        self.end = end
        self.length = getLength()
    }
    
        func getLength() -> Double{
            let distance: Double = Double(abs(Int(end.y - start.y)^2) + abs(Int(end.x - start.x)^2)).squareRoot()
            print("The length of this line is \(distance)")
            return distance.rounded()
        }
}

struct Triangle {
    var points : [Point]
    
    func findBase() -> Any{
        for i in 0...(points.count - 1){
            let currentPoint = points[i]
            for j in 0...(points.count - 1){
                let currentCheck = points[j]
                if currentCheck.x != Double(currentPoint.x){
                    if currentCheck.y == Double(currentPoint.y){
                        let base = Line(start:currentCheck, end: currentPoint)
                        return base
                    }
                }
            }
        }
        return "No intersecting lines!"
    }
    
    func getSides() -> [Line] {
        let line1 = Line(start: points[0], end: points[2])
        let line2 = Line(start: points[0], end: points[1])
        let line3 = Line(start: points[1], end: points[2])
        
        let lines: [Line] = [line1,line2,line3]
        return lines
    }
    
    func findArea() -> Double{
        var s: Double = 0
        let sides = getSides()
        for line in sides {
            s += line.length
            
        }
        s = s/2
        let side1 = sides[0]
        let side2 = sides[1]
        let side3 = sides[2]
        print(side1.length)
        print("s: \(s)")
        let area = (s * (s-side1.length) * (s-side2.length) * (s-side3.length)).squareRoot()
        print("area \(area)")
        return area.rounded()
    }
    
}

var point1 = Point(x:0, y:0)
var point2 = Point(x:-4, y:-3)
var point3 = Point(x:4, y:-3)

var line1 = Line(start: point1, end: point3)
var line2 = Line(start: point1, end: point2)
var line3 = Line(start: point2, end: point3)

var triangle = Triangle(points: [point1,point2,point3])

print(line1.getLength())

print(triangle.findBase())
print(triangle.findArea())
var base = triangle.findBase()




