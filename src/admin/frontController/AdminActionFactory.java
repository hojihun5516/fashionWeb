package admin.frontController;

import admin.controller.action.Action;
import admin.controller.action.AdminFAQAnswerAction;
import admin.controller.action.AdminFAQAnswerDeleteAction;
import admin.controller.action.AdminFAQBoardDeleteAction;
import admin.controller.action.AdminFAQBoardListAction;
import admin.controller.action.AdminFAQViewAction;
import admin.controller.action.AdminFreeBoardDeleteAction;
import admin.controller.action.AdminFreeBoardListAction;
import admin.controller.action.AdminFreeBoardViewAction;
import admin.controller.action.AdminMainAction;
import admin.controller.action.AdminMemberDeleteAction;
import admin.controller.action.AdminMemberUpdateAction;
import admin.controller.action.AdminMemberUpdateForm;
import admin.controller.action.AdminNewsDeleteAction;
import admin.controller.action.AdminNewsListAction;
import admin.controller.action.AdminNoticeBoardDeleteAction;
import admin.controller.action.AdminNoticeBoardListAction;
import admin.controller.action.AdminNoticeBoardUpdate;
import admin.controller.action.AdminNoticeBoardUpdateForm;
import admin.controller.action.AdminNoticeBoardViewAction;
import admin.controller.action.AdminSnapBoardDeleteAction;
import admin.controller.action.AdminSnapBoardListAction;
import admin.controller.action.AdminMemberListAction;

public class AdminActionFactory {

	private AdminActionFactory() {
	}

	private static AdminActionFactory factory = new AdminActionFactory();

	public static AdminActionFactory getInstance() {
		return factory;
	}

	public Action getAction(String command) {

		System.out.println("ActionFactory : " + command);

		Action action = null;

		if (command.equals("admin_main_page")) {
			action = new AdminMainAction();
		} else if (command.equals("admin_member_list")) {
			action = new AdminMemberListAction();
		} else if (command.equals("admin_free_board_list")) {
			action = new AdminFreeBoardListAction();
		} else if (command.equals("admin_notice_board_list")) {
			action = new AdminNoticeBoardListAction();
		} else if (command.equals("admin_snap_board_list")) {
			action = new AdminSnapBoardListAction();
		} else if (command.equals("admin_faq_board_list")) {
			action = new AdminFAQBoardListAction();
		} else if (command.equals("admin_member_update_form")) {
			action = new AdminMemberUpdateForm();
		} else if (command.equals("admin_member_update")) {
			action = new AdminMemberUpdateAction();
		} else if (command.equals("admin_member_delete")) {
			action = new AdminMemberDeleteAction();
		} else if (command.equals("admin_free_board_delete")) {
			action = new AdminFreeBoardDeleteAction();
		} else if (command.equals("admin_notice_board_view")) {
			action = new AdminNoticeBoardViewAction();
		} else if (command.equals("admin_notice_board_delete")) {
			action = new AdminNoticeBoardDeleteAction();
		} else if (command.equals("admin_notice_board_update_form")) {
			action = new AdminNoticeBoardUpdateForm();
		} else if (command.equals("admin_notice_board_update")) {
			action = new AdminNoticeBoardUpdate();
		} else if (command.equals("admin_snap_board_delete")) {
			action = new AdminSnapBoardDeleteAction();
		} else if (command.equals("admin_faq_board_delete")) {
			action = new AdminFAQBoardDeleteAction();
		} else if (command.equals("admin_free_board_view")) {
			action = new AdminFreeBoardViewAction();
		} else if (command.equals("admin_news_board_list")) {
			action = new AdminNewsListAction();
		} else if (command.equals("admin_news_delete")) {
			action = new AdminNewsDeleteAction();
		} else if (command.equals("admin_faq_view")) {
	         action = new AdminFAQViewAction();
	    } else if (command.equals("admin_FAQ_answer")) {
	         action = new AdminFAQAnswerAction();
	    } else if (command.equals("admin_FAQ_answer_delete")) {
	         action = new AdminFAQAnswerDeleteAction();
	    }
		return action;
	}

}
