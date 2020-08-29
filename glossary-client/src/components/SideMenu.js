import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Layout, Menu } from 'antd';
import { PieChartOutlined, DesktopOutlined } from '@ant-design/icons';

const { Sider } = Layout;

class AppFooter extends Component {
  state = {
    collapsed: false,
  };

  onCollapse = (collapsed) => {
    this.setState({ collapsed });
  };
  toggle = () => {
    this.setState({
      collapsed: !this.state.collapsed,
    });
  };

  render() {
    return (
      <Sider collapsible collapsed={this.state.collapsed} onCollapse={this.onCollapse}>
        <div className="logo" />
        <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
          <Menu.Item key="1">
            <PieChartOutlined />
            <span>Deshboard</span>
            <Link to="/" />
          </Menu.Item>
          <Menu.Item key="2">
            <DesktopOutlined />
            <span>Word</span>
            <Link to="/word" />
          </Menu.Item>
        </Menu>
      </Sider>
    );
  }
}

export default AppFooter;
