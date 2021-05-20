

class UserController < ApplicationController
    def index 
        render plain: "Welcome to the integrating models app"
    end

    def user_api
        render json: User.all 
    end

    def new_user
        render 'index' 
    end

    def user_info
        @user = User.find(params[:id])
        render json: @user 
    end

    def create 
        User.create(name: params[:name])
        redirect_to '/users'
    end

    def edit 
        @user = User.find(params[:id])
    end

    def total 
        render json: {"total": User.count}
    end



end
