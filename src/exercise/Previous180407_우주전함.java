package exercise;

public class Previous180407_우주전함 {
/*
 N*M의 좌표계에 숫자가 들어있다.
 숫자가 들어 있는 좌표는 지구연합의 전함이 있고, 각 숫자는 쉴드의 강도를 말한다.
 숫자가 0으로 들어 있는 곳은 외계연합의 전함이 있고, 매 주기마다 지구연합의 전함을 상하좌우로 공격한다.
 공격받은 지구연합의 전함은 쉴드의 강도가 1이 떨어진다
 단, 한번 공격받은 지구연합의 전함은 다른 외계연합의 전함으로부터 공격을 받아도 쉴드의 강도가 줄어들지 않는다
 (즉, 한주기에 쉴드는 1만 떨어진다.)
각 지구연합의 전함이 파괴되는데 걸리는 주기들의 합을 구하라
쉴드는 1~9사이의 숫자를 가진다

좌표계는 모두 외계전함으로 둘러져 있다고 가정한ㄷ
ex)

010
101
010의 좌표계라고 하면 실제로는

00000
00100
01010
00100
00000


첫번째 줄에는 테스트케이스의 숫자
두번째 줄 첫번째 숫자는 N, 두번째 숫자는 M
세번째숫자부터는 좌표계의 숫자

3
3 3
010
101
010
3 3
010
121
010
5 5
00000
01110
01010
01110
00000

#1 4
#2 7
#3 8
 * */
	
	static int N,M,TC;
	static int [][]battleField;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
