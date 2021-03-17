
function f2() {
    alert("f2")
}


function f1(fun) {
    fun.apply();
}


f1(f2());