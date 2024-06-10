Import java.util.ArrayList;
Import java.util.Collections;
Import java.util.Scanner;

Public class BigIntegerCustom {

    Private ArrayList<Integer> list;

    Public BigIntegerCustom(String d) {
        For (char c : d.toCharArray()) {
            If (Character.isLetter©) 
                Throw new IllegalArgumentException(«Illegal character: « + c);
            }
        }
        D = d.replaceAll(« «, «»);
        List = new ArrayList<>();
        For (int i = 0; i < d.length(); i++) {
            List.add(d.charAt(i) – '0');
        }
    }

    Public static ArrayList<Integer> addBigInt(BigIntegerCustom a, BigIntegerCustom b) {
        ArrayList<Integer> aList = a.getList();
        ArrayList<Integer> bList = b.getList();
        ArrayList<Integer> result = new ArrayList<>();
        Int itA = aList.size() – 1;
        Int itB = bList.size() – 1;
        Int carry = 0;

        While (itA >= 0 || itB >= 0) {
            Int sum = carry;
            If (itA >= 0) {
                Sum += aList.get(itA);
                itA--;
            }
            If (itB >= 0) {
                Sum += bList.get(itB);
                itB--;
            }
            Carry = sum / 10;
            Result.add(sum % 10);
        }
        If (carry > 0) {
            Result.add(carry);
        }
        Collections.reverse(result);
        Return result;
    }

    Public static ArrayList<Integer> subtractBigInt(BigIntegerCustom a, BigIntegerCustom b) {
        ArrayList<Integer> aList = a.getList();
        ArrayList<Integer> bList = b.getList();
        ArrayList<Integer> result = new ArrayList<>();
        If (aList.size() < bList.size() || (aList.size() == bList.size() && aList.get(0) < bList.get(0))) {
            Throw new IllegalArgumentException(«a should be greater than or equal to b»);
        }
        Int itA = aList.size() – 1;
        Int itB = bList.size() – 1;
        Int borrow = 0;

        While (itA >= 0 || itB >= 0) {
            Int digitA = itA >= 0 ? aList.get(itA) : 0;
            Int digitB = itB >= 0 ? bList.get(itB) : 0;
            digitA -= borrow;
            if (digitA < digitB) {
                digitA += 10;
                borrow = 1;
            } else {
                Borrow = 0;
            }
            Result.add(digitA – digitB);
            If (itA >= 0) itA--;
            If (itB >= 0) itB--;
        }
        While (result.size() > 1 && result.get(result.size() – 1) == 0) {
            Result.remove(result.size() – 1);
        }
        Collections.reverse(result);
        Return result;
    }

    Public static ArrayList<Integer> multiplyBigInt(BigIntegerCustom a, BigIntegerCustom b) {
        ArrayList<Integer> aList = a.getList();
        ArrayList<Integer> bList = b.getList();
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(aList.size() + bList.size(), 0));
        For (int i = aList.size() – 1; i >= 0; i--) {
            For (int j = bList.size() – 1; j >= 0; j--) {
                Int product = aList.get(i) * bList.get(j);
                Int tempSum = result.get(i + j + 1) + product;
                Result.set(i + j + 1, tempSum % 10);
                Result.set(i + j, result.get(i + j) + tempSum / 10);
            }
        }
        While (result.size() > 1 && result.get(0) == 0) {
            Result.remove(0);
        }
        Return result;
    }

    Public static ArrayList<Integer> divideBigInt(BigIntegerCustom a, BigIntegerCustom b) {
        ArrayList<Integer> aList = a.getList();
        ArrayList<Integer> bList = b.getList();
        If (bList.size() == 1 && bList.get(0) == 0) {
            Throw new IllegalArgumentException(«Division by zero is not allowed»);
        }
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        For (int i = 0; i < aList.size(); i++) {
            Current.add(aList.get(i));
            Int count = 0;
            While (compareLists(current, bList) >= 0) {
                Current = subtractLists(current, bList);
                Count++;
            }
            Result.add(count);
        }
        While (result.size() > 1 && result.get(0) == 0) {
            Result.remove(0);
        }
        Return result;
    }

    Private static int compareLists(ArrayList<Integer> a, ArrayList<Integer> b) {
        If (a.size() != b.size()) {
            Return a.size() – b.size();
        }
        For (int i = 0; i < a.size(); i++) {
            If (!a.get(i).equals(b.get(i))) {
                Return a.get(i) – b.get(i);
            }
        }
        Return 0;
    }

    Private static ArrayList<Integer> subtractLists(ArrayList<Integer> a, ArrayList<Integer> b) {
        Int borrow = 0;
        ArrayList<Integer> result = new ArrayList<>();
        For (int i = 0; i < a.size(); i++) {
            Int digitA = a.get(i) – borrow;
            Int digitB = i < b.size() ? b.get(i) : 0;
            If (digitA < digitB) {
                digitA += 10;
                borrow = 1;
            } else {
                Borrow = 0;
            }
            Result.add(digitA – digitB);
        }
        While (result.size() > 1 && result.get(result.size() – 1) == 0) {
            Result.remove(result.size() – 1);
        }
        Return result;
    }

    Public ArrayList<Integer> getList() {
        Return this.list;
    }

    Public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(«Enter the first number:»);
        String num1 = scanner.nextLine();
        BigIntegerCustom bigInt1 = new BigIntegerCustom(num1);

        System.out.println(«Enter the second number:»);
        String num2 = scanner.nextLine();
        BigIntegerCustom bigInt2 = new BigIntegerCustom(num2);

        // Addition
        ArrayList<Integer> additionResult = BigIntegerCustom.addBigInt(bigInt1, bigInt2);
        System.out.println(«Addition Result: « + additionResult);

        // Subtraction
        ArrayList<Integer> subtractionResult = BigIntegerCustom.subtractBigInt(bigInt1, bigInt2);
        System.out.println(«Subtraction Result: « + subtractionResult);

        // Multiplication
        ArrayList<Integer> multiplicationResult = BigIntegerCustom.multiplyBigInt(bigInt1, bigInt2);
        System.out.println(«Multiplication Result: « + multiplicationResult);

        // Division
        ArrayList<Integer> divisionResult = BigIntegerCustom.divideBigInt(bigInt1, bigInt2);
        System.out.println(«Division Result: « + divisionResult);

        Scanner.close();
    }
}
