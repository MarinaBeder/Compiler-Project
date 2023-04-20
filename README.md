# **Compiler** 



> #### ANTLER Version 

```
4.11.0
```

> ### <span style='color:blue'>Example 1 </span>

```
 
class output {
    public static void main(String[] args)  {
        int x=6;
        int y=10;
        int z=0;
        int r=0;
        if(y==10&&x==6) {
                r=1; }
        if(y==11||z==0)  {
            x= fun(10);
        }
        if(x==10||z==5) {
            r=10;
        }
    }
    static int fun(int x) {
        return 5;
    }
}


```

![1](https://user-images.githubusercontent.com/66501215/233376420-12cce404-588f-42bc-a2df-1852ed55be93.PNG)

```
block number 1
block number 2
block number 3
block number 5

```



> ##  <span style='color:red'>----------------------------------------------------------------------------</span>

### <span style='color:blue'>Example 2 </span>

```
 
class output {
    public static void main(String[] args)  {
        int x=6;
        int y=10;
        int z=0;
        int r=0;

        if(z==0)  {
            x=5;}
        if(x==5){
            x=10;}
        if(x==10||z==5) {
            r=10; }
        if(y==10&&x==6) {
            z=0; }

        for(int i=0;i<5;i++){y=11;}
    }}

```

![2](https://user-images.githubusercontent.com/66501215/233376585-f3159dda-d491-4685-9671-a893ad1a4123.PNG)

```
block number 1
block number 2
block number 3
block number 4
block number 6
block number 6
block number 6
block number 6
block number 6


```

> ##  <span style='color:red'>------------------------------------------------------------------------</span>

### <span style='color:blue'>Example 3 </span>



> ```
> class output {
>  public static void main(String[] args)  { 
>         int x=6;
>         int y=10;
>         int z=0;
>         int r=0;
>         
>       while(x>0){
>             r=10;
>             x--;}
>       if(r==10||y==11)  {
>             x=5;}
>       if(x==15)  {
>             x=5;}
>       else{x=6;}
>     }}
> ```
>
> ![3](https://user-images.githubusercontent.com/66501215/233376812-da7ec66e-c43f-4862-aad1-693c16658170.PNG)
>
> ```
> block number 1
> block number 2
> block number 2
> block number 2
> block number 2
> block number 2
> block number 2
> block number 3
> block number 5
> 
> 
> ```
>
> 
