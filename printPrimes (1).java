 void printPrimes(int max){
        boolean prime = true;
            for (int n = 2; n <= max; n++ ){
                for (int i = 2; i <Math.sqrt(n) +1 ; i++){
                    if (n == 2){break;}
                    if (n % i == 0){

                        prime = false;
                    }
                }
                if (prime == true){
                    System.out.println(n + " is prime");
                }
                prime = true;
            }
        }