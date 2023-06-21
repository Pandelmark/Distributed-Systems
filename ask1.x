struct str1{
    int n;
    int X<>;
    int Y<>;
};

struct str2{
    int n;
    int X<>;
    int Y<>;
};

struct str3{
    int n;
    int X<>;
    int Y<>;
    float r;
};

struct out1{
    float arr1<2>;
};

struct out2{
    float arr2<>;
};

program CALC_PROG{
    version innerProduct_vers{
        int innerProduct(str1) = 1;
        out1 average(str2) = 2;
        out2 product(str3) = 3;
    } = 1;

} = 0x23451111;