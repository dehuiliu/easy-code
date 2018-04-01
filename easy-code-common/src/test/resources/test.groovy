class MyTest {
    def entryMethod(def args) {
        println '------' + 是否为空(取值(""))
//
//        println '------' + 是否为空(取值("1"))
//
//        println '------' + 取值('1234567890')
//
//        if (是否为空(取值('222'))) {
//            WARN("异常测试")
//        }
        if (相等("1", 取值('1'))) {
            WARN("exception ------")
        }
        println '---------------end'
    }
}