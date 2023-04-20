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

> ![](C:\Users\marin\AppData\Roaming\Typora\typora-user-images\image-20230420135847669.png)



```
block number 1
block number 2
block number 3
block number 5

```



> ##  <span style='color:red'>-------------------------------------------------------------------------------------------------------</span>

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

> ![](C:\Users\marin\AppData\Roaming\Typora\typora-user-images\image-20230420141447646.png)



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



> ##  <span style='color:red'>-------------------------------------------------------------------------------------------------------</span>

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
> > ![](C:\Users\marin\AppData\Roaming\Typora\typora-user-images\image-20230420142207298.png)
>
> 
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
