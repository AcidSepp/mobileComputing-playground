void main() {
  final MyJavaClass myJavaClass = new MyJavaClass();
  final MyKotlinClass myKotlinClass = new MyKotlinClass();

  IO.println(myJavaClass.getClass().getCanonicalName());
  IO.println(myKotlinClass.getClass().getCanonicalName());
}
