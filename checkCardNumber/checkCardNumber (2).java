 boolean checkCardNumber(String cardNumber){
        
        if (cardNumber.length() == 0 || cardNumber.length() < 4){
            return false;
        }
        
        for (int i = 0; i < cardNumber.length(); i++){
            if (Character.isDigit(cardNumber.charAt(i)) == false){
                return false;
            }
        }
        int l = cardNumber.length();
        
        char[] num_array = cardNumber.toCharArray();
        String firstDigits = "";
        
        //loop through first digits and check network of the card
        for (int i = 0; i < 4; i++){
            firstDigits = firstDigits + num_array[i];
            int fDNumeric = Integer.valueOf(firstDigits);
            //Visa
            if (fDNumeric == 4){
                if (l == 13 || l == 16 || l == 19){
                    break;
                }
                else {
                    return false;
                }
            }
            //American Express
            if (fDNumeric == 34 || fDNumeric == 37){
                if (l == 15){
                    break;
                }
                else {
                    return false;
                }
            }
            //UnionPay
            if (fDNumeric == 62){
                if (l == 16 || l == 17 || l == 18 || l == 19){
                    break;
                }
                else {
                    return false;
                }
            }
            //MasterCard
            if ((fDNumeric >= 51 && fDNumeric <= 55) || (fDNumeric >= 2221 && fDNumeric <= 2720)){
                if (l == 16){
                    break;
                }
                else {
                    return false;
                }
            }
            
        }
        String digit_rev =  new StringBuilder(cardNumber).reverse().toString();
        
        int sum = 0;
        boolean isSecond = false;
        for (int i = 0; i < l; i++){
            
            int j = Integer.valueOf(digit_rev.substring(i, i+1));
            
            if (isSecond == true){
                j = j*2;
                if (j > 9){
                    j = j - 9;
                }
            }
            sum = sum + j;
            isSecond = !isSecond;
            
        }
        if (sum % 10 == 0){
            return true;
        }
        
        
        return false;
        
        
    }
