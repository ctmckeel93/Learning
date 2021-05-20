require 'application_controller'

class DisplaysController < ApplicationController
  def index
    render plain: "What do you want me to say"
  end

  def hello
    render plain: "Hello, Coding Dojo"
  end

  def say
    unless params[:name]
      render plain: "Saying Hello"
    else 
      if params[:name] == 'michael'
        redirect_to '/say/hello/joe'
      else 
        render plain: "Saying Hello #{params[:name]}!"
      end
    end 
  end

  def visit 
    session[:count] ||= 0
      
    render plain: "You have visited this route #{session[:count] += 1} time(s)!"
  end 

  def restart 
    reset_session
    render plain: "You destroyed the session"
  end
end
