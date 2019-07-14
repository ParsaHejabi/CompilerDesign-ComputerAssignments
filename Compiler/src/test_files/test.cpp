##func_dcl
function void method_callA();
##struct_dec
record myRecord
begin
    int a;
    double b,c = 2.0;
    string s = "kir to bardia";
end;
##var_dcl
const int var_dclA = method_callA();
bool var_dclB = not true;

function int main()
begin
    int a = 2;
    return 0;
end