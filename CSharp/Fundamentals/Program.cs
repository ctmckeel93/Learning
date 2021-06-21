using System;

namespace Fundamentals
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            // printValues();
            fizzBuzz();
        }
        static void printValues()
        {
            for (int i = 1; i <= 255; i++)
            {
                Console.WriteLine(i);
            }
        }

        static void fizzBuzz()
        {
            for (int i = 1; i <= 100; i++){
                if (i % 3 == 0 && i % 5 == 0 ){
                    Console.WriteLine("FizzBuzz");
                }
                else if (i % 3 == 0 || i % 5 == 0){
                    if (i%3 == 0)
                    {
                        Console.WriteLine("Fizz");
                    }
                    else {
                        Console.WriteLine("Buzz");
                    }
                }
            }
        }

    }
}

