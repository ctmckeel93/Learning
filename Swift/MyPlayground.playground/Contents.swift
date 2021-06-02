import UIKit

func numSum() {
    var sum = 0
    for i in 1...255 {
        sum += i
        print(sum)
    }
}

//numSum()

var numArray: [UInt32] = [1,3,7,22,90,103,42,777]
func Shuffle(arr: [UInt32]) {
    var result = arr
    let x = UInt32(arr.count)
    var val1 = 0
    var val2 = 0
    for i in 1...100 {
        val1 = Int(arc4random_uniform(x))
        val2 = Int(arc4random_uniform(x))
        result.swapAt(val1,val2)
        print("loop \(i)")
    }
    
    print(result)
}

Shuffle(arr:numArray)


func lifesMeaningIs(arr: [Int]) -> String {
    for i in 0...(arr.count-1) {
        if arr[i] == 42 {
            print(i)
            return("I have found the answer to the meaning of life at index \(i)")
        }
    }
    return "Will we ever discover the mystery of life?"
}

print(lifesMeaningIs(arr:[1,3,7,22,90,103,777]))




