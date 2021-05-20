require 'test_helper'

class DisplaysControllerTest < ActionDispatch::IntegrationTest
  test "should get index" do
    get displays_index_url
    assert_response :success
  end

  test "should get hello" do
    get displays_hello_url
    assert_response :success
  end

end
