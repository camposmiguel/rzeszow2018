"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const jwt = require("jsonwebtoken");
class AuthHelper {
    genToken(userLogged) {
        const token = {
            token: jwt.sign({
                user: userLogged,
                exp: Math.round(new Date().getTime() / 1000) + 604800
            }, 'my-secret')
        };
        return token.token;
    }
}
exports.AuthHelper = AuthHelper;
//# sourceMappingURL=auth.helper.js.map