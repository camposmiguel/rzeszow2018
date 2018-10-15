"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
const common_1 = require("@nestjs/common");
const exercise_entity_1 = require("./exercise.entity");
const exercise_service_1 = require("./exercise.service");
const exercise_controller_1 = require("./exercise.controller");
const typeorm_1 = require("@nestjs/typeorm");
const auth_middleware_1 = require("middlewares/auth.middleware");
let ExerciseModule = class ExerciseModule {
    configure(consumer) {
        consumer.apply(auth_middleware_1.AuthMiddleware).forRoutes(exercise_controller_1.ExerciseController);
    }
};
ExerciseModule = __decorate([
    common_1.Module({
        imports: [typeorm_1.TypeOrmModule.forFeature([exercise_entity_1.Exercise])],
        providers: [exercise_service_1.ExerciseService],
        controllers: [exercise_controller_1.ExerciseController],
    })
], ExerciseModule);
exports.ExerciseModule = ExerciseModule;
//# sourceMappingURL=exercise.module.js.map