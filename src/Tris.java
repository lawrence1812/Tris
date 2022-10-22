
class Tris {
    final int X = 1;
    final int O = -1;
    final int E = 0;

    final int PAREGGIO = 2;
    final int PARTITA_IN_CORSO = 0;

    
    int[][] field = new int[3][3];
    

    public String trisToString() {
        String str = "";
        for(int i = 0; i < field.length; i++) {
            for(int j  = 0; j < field[0].length; j++) {
                str += singToChar(field[i][j]) + " ";
            }
            str += "\n";
        }
        return str;
    }
    public char singToChar(int sing) {
        if(sing == X) return 'X';
        if(sing == O) return 'O';
        return '-';
    }

    public void play(int x, int y, int sign) {
        if(isPlayable(x,y)) {
            field[x][y] = sign;
        } else {
            System.out.println("Casella non libera");
        }
        
    }
    
    public boolean isPlayable(int x, int y) {
        if(field[x][y] == E) return true;
        return false;
    }
    
    public int verifica() {
        if(Math.abs(field[0][0] + field[0][1] + field[0][2]) == 3) return field[0][0];
        if(Math.abs(field[1][0] + field[1][1] + field[1][2]) == 3) return field[1][0];
        if(Math.abs(field[2][0] + field[2][1] + field[2][2]) == 3) return field[2][0];
        if(Math.abs(field[0][0] + field[1][0] + field[2][0]) == 3) return field[0][0];
        if(Math.abs(field[0][1] + field[1][1] + field[2][1]) == 3) return field[0][1];
        if(Math.abs(field[0][2] + field[1][2] + field[2][2]) == 3) return field[0][2];
        if(Math.abs(field[0][0] + field[1][1] + field[2][2]) == 3) return field[0][0];
        if(Math.abs(field[0][2] + field[1][1] + field[2][0]) == 3) return field[0][2];
        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[0].length; j++) {
                if(field[i][j] == E) {
                    return PARTITA_IN_CORSO;
                }
            }
        }
        return PAREGGIO;
    }
    

}


