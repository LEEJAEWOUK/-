package Programming;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;
import java.awt.Dimension;

public class CBT extends JFrame implements ActionListener {

	static JFrame frm = new JFrame("CBT!");
	JRadioButton btn[] = new JRadioButton[4];
	//JRadioButton m_answer[] = new JRadioButton[btn.length];
	JButton move;
	JButton before;
	static JLabel Time_label = new JLabel();
	JLabel label[] = new JLabel[3];
	ButtonGroup group = new ButtonGroup();

	int i = 0, j = 0;
	int right = 0;

	static int time_count = 60; // 초
	static int secs = time_count;
	static int mins = secs / 60;

	String que[] = { "한글을 창제하신분은?", "디지텍고 교장선생님의 성함은?", " 1+2 = ? " };
	String bwn[][] = { { "율곡이이", "세종대왕", "티모", "호날두" }, { "곽스타", "곽천일", "곽일천", "곽한구" }, { "1", "5", "4", "3" } };
	int awn[] = { 2, 3, 4 };// 정답
	int my_awn[] = new int[3]; // 내가 입력할 답

	public CBT() {
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		frm.setSize(res.width, res.height);
		frm.setVisible(true);
		frm.setLayout(null);

		Button();
		Label();
		bn();
	}

	void Last() {
		int select = JOptionPane.showConfirmDialog(null, "제출하시겠습니까?", "마지막 문제입니다.", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (select == JOptionPane.YES_OPTION)
			finish();
		for (int i = 0; i < 4; i++) {

		}
	}

	void bn() {
		frm.add(before = new JButton("<<"));
		before.setBounds(500, 600, 100, 50);
		before.addActionListener(this);

		frm.add(move = new JButton(">>"));
		move.setBounds(650, 600, 100, 50);
		move.addActionListener(this);

	}

	void Label() {

		frm.add(label[j] = new JLabel(que[j], JLabel.CENTER));

		label[j].setBounds(75, 30, 950, 250);
		label[j].setOpaque(true); // Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		label[j].setBackground(Color.pink);

		Font Que = new Font("맑은 고딕", Font.PLAIN, 30); // 폰트 설정
		label[j].setFont(Que);

	}

	void Button() {

		for (i = 0; i < 4; i++) {
			frm.add(btn[i] = new JRadioButton(bwn[j][i]));
			group.add(btn[i]);
			btn[i].addActionListener(this);
			btn[i].setBounds(70, 300 + (100 * i), 100, 50);

			Font Btn = new Font("맑은 고딕", Font.PLAIN, 16); // 폰트 설정

			btn[i].setFont(Btn);
		}
	}

	void finish() {
		for (i = 0; i < 3; i++) {
			if (my_awn[i] == awn[i]) // 입력한 답과 정답을 비교
				right++;
		}
		System.out.println(right + "개 맞았습니다."); // 맞은 개수 출력

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.exit(1);
	}

	void Question() {
		Button();
		Label();
	}

	// 메인!!
	public static void main(String[] args) {
		Timer timer = new Timer(); // 타이머
		timer.schedule(new WorkTask(), 1000, 1000); // 1초 후 부터 시작
		new CBT();
	}

	public static class WorkTask extends TimerTask {
		@Override
		public void run() {
			time_count--; // 5분에서 1초씩 차감
			secs = time_count; // 초 변수에 현재 시간을 넣음
			mins = secs / 60; // 초 변수를 60으로 나눠 분을 구함
			secs = secs % 60; // 초에서 60으로 나눈 후 나머지를 구함

			frm.add(Time_label = new JLabel(mins + " : " + secs, JLabel.CENTER)); // 타이머
																					// 라벨
																					// 생성,
																					// 가운데
																					// 정렬
			if (mins == 0 && secs == 0) {
				CBT cbt = new CBT();

				cbt.finish();
			}

			Time_label.setBounds(1050, 30, 300, 200);
			Time_label.setOpaque(true);
			Time_label.setBackground(Color.black);

			Font timer = new Font("맑은 고딕", Font.PLAIN, 20); // 폰트 설정
			Time_label.setFont(timer);

			Time_label.setForeground(Color.WHITE);
		}
	}

	public void actionPerformed(ActionEvent e) {

		if (j == 0) {
			for (i = 0; i < 4; i++) {
				if (e.getSource().equals(btn[i]))
					my_awn[j] = i + 1;
			}
		}

		else if (j == 1) {
			for (i = 0; i < 4; i++) {
				if (e.getSource().equals(btn[i]))
					my_awn[j] = i + 1;
			}
		}

		else if (j == 2) {
			for (i = 0; i < 4; i++) {
				if (e.getSource().equals(btn[i]))
					my_awn[j] = i + 1;
			}
		}

		if (e.getSource().equals(before)) {
			for (i = 0; i < 4; i++) {
				btn[i].setVisible(false); // 버튼 보이지 않게 하기
			}
			label[j].setVisible(false); // 문제넘기기

			j--;

			if (j == -1)
				j = 0;

			Question();

		}

		if (e.getSource().equals(move)) {
			for (i = 0; i < 4; i++) {
				btn[i].setVisible(false); // 버튼 보이지 않게 하기
			}
			label[j].setVisible(false);

			j++;

			if (j == 3) {
				Last();
				j--;
			}
			// finish(); 끝내는 버튼 만들 예정입니다.
			// 타이머 끝내도 나오는 메소드
			Question();
		}
	}
}