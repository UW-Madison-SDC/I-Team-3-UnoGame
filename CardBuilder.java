public class CardBuilder {

    public static Cards[] buildInitial(){
        Cards[] deck = new Cards[108];
        int deckSize = 0;
        // 4 zeros of each color
        for(int i = 0; i < 4; i++){
            deck[deckSize] = new Cards(i, 0);
            deckSize++;
        }

        // 2 faceVal of each color from 1-9
        for (int i = 0; i < 4; i++){
            for (int j = 1; j <= 9; j++){
                deck[deckSize] = new Cards(i, j);
                deckSize++;
                deck[deckSize] = new Cards(i, j);
                deckSize++;
            }
            // two of each color for +2
            deck[deckSize] = new PlusTwo(i);
            deckSize++;
            deck[deckSize] = new PlusTwo(i);
            deckSize++;

            // two of each color for +2
            deck[deckSize] = new Reverse(i);
            deckSize++;
            deck[deckSize] = new Reverse(i);
            deckSize++;

            // two of each color for +2
            deck[deckSize] = new Skip(i);
            deckSize++;
            deck[deckSize] = new Skip(i);
            deckSize++;
        }

        for (int i = 0; i < 4; i++){
            deck[deckSize] =  new Wild();
            deckSize++;
            deck[deckSize] =  new WildPlusFour();
            deckSize++;
        }

//        System.out.println("Pre-shuffle: ");
//        for(Cards card : deck){
//            System.out.println(card);
//        }
//
//        Shuffle.shuffleArray(deck);
//
//        System.out.println("Post-shuffle: ");
//        for(Cards card : deck){
//            System.out.println(card);
//        }
//
//        String test = "";
//
//        for(Cards card : deck){
//            test += card.getID() + ",";
//        }
//
//        System.out.println(test);
        return deck;
    }

    public static Cards[] build(Cards[] discard){
        Shuffle.shuffleArray(discard);
        return discard;
    }
}
