# 关于反射内容总结

### Class对象的三种获取方式
- Class.class
- object.getClass()
- Class.forName("类完整路径名")


### 反射中的getDeclared**与get**的区别 
- getDeclared**  返回的只是当前类（即没有子类、父类）中，被public、proteced、private和默认 修饰符修饰对应的Method、Field

### setAccessible
 
