import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
import { Layout, Menu } from 'antd';
import {
  PieChartOutlined,
  DesktopOutlined,
  MenuUnfoldOutlined,
  MenuFoldOutlined,
} from '@ant-design/icons';

import AppHeader from './AppHeader';
import SideMenu from './SideMenu';
import Dashboard from '../containers/dashboard/Dashboard';
import Word from '../containers/word/Word';

import 'antd/dist/antd.css';
import './App.css';

const { Header, Content, Sider } = Layout;

class App extends Component {
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
      <Router>
        <Layout style={{ minHeight: '100vh' }}>
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
          <Layout>
            <Header style={{ background: '#fff', padding: 0, paddingLeft: 16 }}>
              {this.state.collapsed ? (
                <MenuUnfoldOutlined
                  className="trigger"
                  style={{ cursor: 'pointer', fontSize: 20 }}
                  onClick={this.toggle}
                />
              ) : (
                <MenuFoldOutlined
                  className="trigger"
                  style={{ cursor: 'pointer', fontSize: 20 }}
                  onClick={this.toggle}
                />
              )}
            </Header>
            <Content
              style={{ margin: '24px 16px', padding: 24, background: '#fff', minHeight: 280 }}
            >
              <Route exact path="/" component={Dashboard} />
              <Route path="/word" component={Word} />
            </Content>
          </Layout>
        </Layout>
      </Router>
    );
  }
}

export default App;
