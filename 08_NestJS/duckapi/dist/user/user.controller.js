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
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
Object.defineProperty(exports, "__esModule", { value: true });
const common_1 = require("@nestjs/common");
const user_service_1 = require("./user.service");
let UserController = class UserController {
    constructor(usersService) {
        this.usersService = usersService;
    }
    getAllUsers(res) {
        this.usersService.getAllUsers().then(users => {
            res.status(common_1.HttpStatus.OK).json(users);
        });
    }
    getRanking(res) {
        this.usersService.getRanking().then(ranking => {
            res.status(common_1.HttpStatus.OK).json(ranking);
        });
    }
    getUser(res, id) {
        this.usersService.getUser(id).then(user => {
            res.status(common_1.HttpStatus.OK).json(user);
        });
    }
    createUser(res, username, email, password) {
        this.usersService.createUser(username, email, password).then(result => {
            res.status(common_1.HttpStatus.CREATED).json(result);
        }).catch(() => {
            res.status(common_1.HttpStatus.FORBIDDEN).json({ mensaje: 'Email already exist' });
        });
    }
    updateUser(res, id, username, email, password, ducks) {
        this.usersService.updateUser(id, username, email, password, ducks).then(result => {
            res.status(common_1.HttpStatus.ACCEPTED).json(result);
        });
    }
    updateRank(request, res, ducks) {
        this.usersService.updateRank(request.payload.user.id, ducks).then(result => {
            res.status(common_1.HttpStatus.ACCEPTED).json(result);
        });
    }
    deleteUser(res, id) {
        this.usersService.deleteUser(id).then(result => {
            res.status(common_1.HttpStatus.ACCEPTED).json(result);
        });
    }
};
__decorate([
    common_1.Get('/all'),
    __param(0, common_1.Res()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object]),
    __metadata("design:returntype", void 0)
], UserController.prototype, "getAllUsers", null);
__decorate([
    common_1.Get('/ranking'),
    __param(0, common_1.Res()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object]),
    __metadata("design:returntype", void 0)
], UserController.prototype, "getRanking", null);
__decorate([
    common_1.Get('/:id'),
    __param(0, common_1.Res()), __param(1, common_1.Param('id')),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object, Object]),
    __metadata("design:returntype", void 0)
], UserController.prototype, "getUser", null);
__decorate([
    common_1.Post('/create'),
    __param(0, common_1.Res()), __param(1, common_1.Body('username')), __param(2, common_1.Body('email')), __param(3, common_1.Body('password')),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object, Object, Object, Object]),
    __metadata("design:returntype", void 0)
], UserController.prototype, "createUser", null);
__decorate([
    common_1.Put('/:id'),
    __param(0, common_1.Res()), __param(1, common_1.Param('id')), __param(2, common_1.Body('username')), __param(3, common_1.Body('email')), __param(4, common_1.Body('password')), __param(5, common_1.Body('ducks')),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object, Object, Object, Object, Object, Object]),
    __metadata("design:returntype", void 0)
], UserController.prototype, "updateUser", null);
__decorate([
    common_1.Post('/rank'),
    __param(0, common_1.Req()), __param(1, common_1.Res()), __param(2, common_1.Body('ducks')),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object, Object, Object]),
    __metadata("design:returntype", void 0)
], UserController.prototype, "updateRank", null);
__decorate([
    common_1.Delete('/:id'),
    __param(0, common_1.Res()), __param(1, common_1.Param('id')),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object, Object]),
    __metadata("design:returntype", void 0)
], UserController.prototype, "deleteUser", null);
UserController = __decorate([
    common_1.Controller('user'),
    __metadata("design:paramtypes", [user_service_1.UserService])
], UserController);
exports.UserController = UserController;
//# sourceMappingURL=user.controller.js.map