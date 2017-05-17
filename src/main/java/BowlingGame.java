public class BowlingGame {

    public int getScore(char a){
		if(a=='X')
			return 10;
		else if(a=='-')
			return 0;
		else
			return a-'0';
	}
    public int getBowlingScore(String bowlingCode) {
    	int score,i,j,group,count;
    	score=0;
    	group=0;
    	for(i=0;i<bowlingCode.length()&&group<10;i++)
    	{
    		if(bowlingCode.charAt(i)=='X')
    		{
    			count=0;
    			for(j=i+1;j<bowlingCode.length()&&count<2;j++)
    			{
    				if(bowlingCode.charAt(j)!='|')
    				{
    					if(bowlingCode.charAt(j)=='/')
    						score+=10-getScore(bowlingCode.charAt(j-1));
    					else
    						score+=getScore(bowlingCode.charAt(j));
    					count++;
    				}
    			}
    			score+=10;
    			group++;
    		}
    		else if(bowlingCode.charAt(i)=='/')
    		{
    			for(j=i+1;j<bowlingCode.length();j++)
    			{
    				if(bowlingCode.charAt(j)!='|')
    				{
    					score+=getScore(bowlingCode.charAt(j));
    					break;
    				}
    			}
    			score+=10;
    			group++;
    		}
    		else
    		{
    			if(bowlingCode.charAt(i+1)=='|')
    			{
    				score+=getScore(bowlingCode.charAt(i))+getScore(bowlingCode.charAt(i-1));
    				group++;
    			}
    		}
    	}
       return score;
    }
}
