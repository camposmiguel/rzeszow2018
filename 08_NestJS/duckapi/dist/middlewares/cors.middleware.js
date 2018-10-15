"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
const common_1 = require("@nestjs/common");
let CorsMiddleware = class CorsMiddleware {
    constructor() { }
    resolve() {
        return (req, res, next) => {
            const allowAll = true;
            const allowedOrigins = ['*', 'http://localhost:3000', 'http://localhost:4200', 'http://www.resucitoapp.com'];
            if (allowAll || allowedOrigins.indexOf(req.header('Origin')) > -1) {
                if (allowAll) {
                    res.setHeader('Access-Control-Allow-Origin', '*');
                }
                else {
                    res.setHeader('Access-Control-Allow-Origin', req.header('Origin'));
                }
                res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE');
                res.setHeader('Access-Control-Allow-Headers', 'Content-Type');
                res.setHeader('Access-Control-Allow-Credentials', true);
            }
            else {
                return res.status(401).json('Origen no permitido');
            }
            next();
        };
    }
};
CorsMiddleware = __decorate([
    common_1.Injectable(),
    __metadata("design:paramtypes", [])
], CorsMiddleware);
exports.CorsMiddleware = CorsMiddleware;
//# sourceMappingURL=cors.middleware.js.map