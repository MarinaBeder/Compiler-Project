# **Compiler** 



> #### ANTLER Version 

```
4.11.0
```

> ## <span style='color:blue'>Parse Tree </span>

```
 
if( x == true ) {
    if (z  == false){
    print();
    }
}
```

> ![](C:\Users\marin\Desktop\100.PNG)

#### 

```
if( x >= 5) {
    if (z<=2){
    a=9;
    }
   if (z<=2)print();
}

```

> ##  ![](C:\Users\marin\Desktop\104.PNG)

#### 

```
if( x >= 5 ) {
    if (z  <=2){
    print();
    a=5;
    }
}
```

> ##  ![](C:\Users\marin\Desktop\101.PNG)

#### 

```
if( x >= 5) {
    a=5;
    print();
    if (z<=2){
        print();
         if (test <= 6){
           a=5;
        }
    }
 }
```

> ##  ![](C:\Users\marin\Desktop\102.PNG)

#### 

```
if( x >= 5) {
   a=8;
   print();
    if (z<=2){
    a=9;
    }
    if (z<=2){
        print();
   }
}

```

> ##  ![](C:\Users\marin\Desktop\103.PNG)

#### 

```

```

> ##  <span style='color:blue'>Sample input/output </span>
>
> ```
> Enter java file path:
> /*file input which contain*/
> if(a==5){
> print();
> a=6;
> if(a==5)print();
> if(a>=0){
>   a=8;
>   print();
>   if(q==9)print();
> }
> }
> ```

#### 

> #### ***output on terminal***
>
> ```
> if (a==5){ //block number 1
> print();
> a=6;
> if (a==5) //block number 2
> print();
> if (a>=0){ //block number 3
> a=8;
> print();
> if (q==9) //block number 4
> print();
> }
> }
> ```
>
> 

> #### ***output on External File***
>
> #### 
>
> ```
> if(a==5) //block number 1
> {
> print();
> a=6;
> if(a==5) //block number 2
> print();
> if(a>=0) //block number 3
> {
> a=8;
> print();
> if(q==9) //block number 4
> print();
> }
> }
> ```
>
> 
