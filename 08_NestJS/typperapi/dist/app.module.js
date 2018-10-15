"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
const common_1 = require("@nestjs/common");
const app_controller_1 = require("./app.controller");
const app_service_1 = require("./app.service");
const typeorm_1 = require("@nestjs/typeorm");
const users_module_1 = require("./user/users.module");
const auth_module_1 = require("./auth/auth.module");
const user_service_1 = require("./user/user.service");
const auth_service_1 = require("./auth/auth.service");
const user_controller_1 = require("./user/user.controller");
const exercise_controller_1 = require("./exercise/exercise.controller");
const exercise_service_1 = require("./exercise/exercise.service");
const exercise_module_1 = require("./exercise/exercise.module");
let AppModule = class AppModule {
};
AppModule = __decorate([
    common_1.Module({
        imports: [
            typeorm_1.TypeOrmModule.forRoot({
                type: 'mysql',
                host: 'localhost',
                port: 3306,
                username: 'root',
                password: '',
                database: 'duck_hunt_api',
                entities: [__dirname + '/**/*.entity{.ts,.js}'],
                synchronize: true,
                charset: 'UTF8_GENERAL_CI'
            }),
            users_module_1.UsersModule,
            auth_module_1.AuthModule,
            exercise_module_1.ExerciseModule,
        ],
        controllers: [app_controller_1.AppController, user_controller_1.UserController, exercise_controller_1.ExerciseController],
        providers: [app_service_1.AppService, user_service_1.UserService, auth_service_1.AuthService, exercise_service_1.ExerciseService],
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map