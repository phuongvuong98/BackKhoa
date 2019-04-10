package lab_3_kiemthu;

public class Calculator {
 public int add(int a, int b) {
  return a + b;
 }
 public int add(int[] a) {
  int total = 0;
  for (int i: a) {
   total += i;
   try {
    Thread.sleep(1000);
   } catch (InterruptedException e) {
    // Nothing
   }
  }
  return total;
 }
 public int sub(int a, int b) {
  return a - b;
 }
 public int mul(int a, int b) {
  return a * b;
 }
 public int div(int a, int b) {
  return a / b;
 }
}
