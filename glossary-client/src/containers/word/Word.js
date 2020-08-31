import React from 'react';
import { PageHeader, Row, Col, Table, Card, Input, Button } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import { getWords } from '../../common/api';

const Word = () => {
  const dataSource = [
    {
      key: '1',
      name: 'Mike',
      age: 32,
      address: '10 Downing Street',
    },
    {
      key: '2',
      name: 'John',
      age: 42,
      address: '10 Downing Street',
    },
  ];

  const columns = [
    {
      title: 'Name',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: 'Age',
      dataIndex: 'age',
      key: 'age',
    },
    {
      title: 'Address',
      dataIndex: 'address',
      key: 'address',
    },
  ];

  return (
    <div>
      <PageHeader
        className="site-page-header"
        //onBack={() => null}
        title="단어 조회"
        subTitle="This is a subtitle"
      />
      <Row style={{ padding: 24 }}>
        <Col span={24}>
          <Card>
            <span style={{ marginRight: 15 }}>검색조건 :</span>
            <Input placeholder="단어를 입력하세요." style={{ width: 400, marginRight: 10 }} />
            <Button type="primary" icon={<SearchOutlined />}>
              Search
            </Button>
          </Card>
        </Col>
        <Col span={24} style={{ marginTop: 24 }}>
          <Table dataSource={dataSource} columns={columns} />
        </Col>
      </Row>
    </div>
  );
};

export default Word;
