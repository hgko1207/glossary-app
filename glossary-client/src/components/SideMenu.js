import React from 'react';
import { Link } from 'react-router-dom';
import { Layout, Menu } from 'antd';
import { PieChartOutlined, DesktopOutlined } from '@ant-design/icons';

const { Sider } = Layout;

const SideMenu = ({ collapsed, onCollapse }) => {
  return (
    <Sider collapsible collapsed={collapsed} onCollapse={onCollapse}>
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
};

export default SideMenu;
