# string2int Challenge

For anyone who accept this challenge, you have to write the program in any language that can retrieve mixed both numerical and alphabetical character and return only the numerical value in interger format.

For example:

A.

- Given input is `"abc573"`
- The output should be `573` in integer.

B.

- Given input is `"a5b7c3"`
- The output should be `573` in integer.

## Rules

- You must not use any parsing, casting or converting function, either it is built-in or come from the library you use.

- To start the challenge please fork this repository can create a commit that you accepting the challenge. You have 30 minutes to complete the challenge, but if you cannot make it take your time. Atfer you finish the coding please commit it again, then you will have unlimited of time to write down the explanation of your solution.

## Grading Criteria

- You will be surely score `100` if your solution can passed all the test cases we have.

## License

The MIT License

Copyright © 2020, AppMan

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


## How to Test
1. getInt
1.1 Success
Endpoint/(intput): 
[GET] http://localhost:8080/test/retrieve/int/a1b2c3d4555

Response:
{
    "transactionId": "dad665e5-418b-48c0-b522-842106390579",
    "errorCode": "200",
    "message": "Success",
    "intInfo": "1234555"
}

1.2 Required
Request: 
[GET] http://localhost:8080/test/retrieve/int/

Response:
{
    "transactionId": "926dabb3-b347-4cd9-901a-f8d4b559867a",
    "errorCode": "500",
    "message": "inputString is required.",
    "intInfo": null
}

2. getIntFromSpecialCharacter
1.1 Success
Endpoint:	http://localhost:8080/test/retrieve/int
Request: 
{
    "inputString": "a1b2c3$W#@!@#$%%^^&&*())_+/..%^d4555^%"
}

Response:
{
    "transactionId": "7c64622e-0c1c-4726-b077-930cae385180",
    "errorCode": "200",
    "message": "Success",
    "intInfo": "1234555"
}

1.2 Required
Endpoint:	http://localhost:8080/test/retrieve/int
Request: 
{
    "inputString": ""
}

Response:
{
    "transactionId": "5a10731d-77ee-47a9-a725-03cb4f2f6c2c",
    "errorCode": "500",
    "message": "inputString is required.",
    "intInfo": null
}