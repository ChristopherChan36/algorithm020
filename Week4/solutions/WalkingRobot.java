public class WalkingRobot {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] direx={0,1,0,-1};
        int[] direy={1,0,-1,0};
        int curx=0,cury=0;
        int curdire=0;
        int comLen=commands.length;
        int ans=0;
        Set<Pair<Integer,Integer>> obstacleSet=new HashSet<>();
        for (int i = 0; i <obstacles.length ; i++) {
            obstacleSet.add(new Pair<>(obstacles[i][0],obstacles[i][1]));
        }
        for (int i = 0; i <comLen ; i++) {
            if(commands[i]==-1){
                curdire=(curdire+1)%4;
            }
            else if(commands[i]==-2){
                curdire=(curdire+3)%4;
            }
            else {
                for (int j = 0; j <commands[i] ; j++) {
                    int nx=curx+direx[curdire];
                    int ny=cury+direy[curdire];
                    if(!obstacleSet.contains(new Pair<>(nx,ny))){
                        curx=nx;
                        cury=ny;
                        ans=Math.max(ans,curx*curx+cury*cury);
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}