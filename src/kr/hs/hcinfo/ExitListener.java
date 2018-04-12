package kr.hs.hcinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ExitListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int flag = JOptionPane.showConfirmDialog(null, "종료하시겠습니까??", "종료확인", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(flag==JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}

}
