package auth;

import model.Operation;
import model.Role;
import model.User;

public final class PermissionPolicy {

    private PermissionPolicy() {
    }

    public static boolean isAllowed(User user, Operation operation) {
        if (user == null) {
            return false;
        }
        return isAllowed(user.getRole(), operation);
    }

    public static boolean isAllowed(Role role, Operation operation) {
        if (role == null || operation == null) {
            return false;
        }

        switch (role) {
            case ADMIN:
                return operation == Operation.USER_MANAGEMENT
                        || operation == Operation.MENU_VIEW
                        || operation == Operation.PRODUCT_CREATE
                        || operation == Operation.PRODUCT_UPDATE
                        || operation == Operation.PRODUCT_DELETE
                        || operation == Operation.TABLE_VIEW
                        || operation == Operation.TABLE_MANAGEMENT
                        || operation == Operation.ORDER_VIEW_ALL;

            case WAITER:
                return operation == Operation.MENU_VIEW
                        || operation == Operation.TABLE_VIEW
                        || operation == Operation.ORDER_CREATE
                        || operation == Operation.ORDER_UPDATE
                        || operation == Operation.ORDER_CANCEL
                        || operation == Operation.VIEW_OWN;

            case KITCHEN_BARISTA:
                return operation == Operation.ORDER_VIEW_PREPARATION_QUEUE
                        || operation == Operation.ORDER_SET_PREPARING
                        || operation == Operation.ORDER_SET_READY;

            default:
                return false;
        }
    }
}