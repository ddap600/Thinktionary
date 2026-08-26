import {useEffect, useState} from "react";

function Dashboard() {

    type PageCollection = {
        id: number;
        name: string;
        createdAt: string;
        updatedAt: string;
    };

    const [pageCollections, setPageCollections] = useState<PageCollection[]>([]);

    useEffect(() => {
        fetch("http://localhost:8080/collection/mine", {
            credentials: "include"
        })
            .then(res => res.json())
            .then(data => setPageCollections(data));
    }, []);

    return (
        <div>
            <h2> Dashboard </h2>
            {pageCollections.map(pageCollection => (
                <div key={pageCollection.id}>
                    {pageCollection.name}
                </div>
            ))}
        </div>)

}

export default Dashboard;