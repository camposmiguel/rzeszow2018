"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Auth {
    constructor(user, token) {
        this.token = token;
        this.username = user.username;
        this.email = user.email;
        this.ducks = user.ducks;
    }
}
exports.Auth = Auth;
//# sourceMappingURL=auth.entity.js.map