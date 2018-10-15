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
const exercise_service_1 = require("./exercise.service");
let ExerciseController = class ExerciseController {
    constructor(exerciseService) {
        this.exerciseService = exerciseService;
    }
    getAllUsers(res) {
        this.exerciseService.getAll().then(exerciseList => {
            res.status(common_1.HttpStatus.OK).json(exerciseList);
        });
    }
};
__decorate([
    common_1.Get('/all'),
    __param(0, common_1.Res()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object]),
    __metadata("design:returntype", void 0)
], ExerciseController.prototype, "getAllUsers", null);
ExerciseController = __decorate([
    common_1.Controller('exercise'),
    __metadata("design:paramtypes", [exercise_service_1.ExerciseService])
], ExerciseController);
exports.ExerciseController = ExerciseController;
//# sourceMappingURL=exercise.controller.js.map