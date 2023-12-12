import React from "react";

export default function PageLayout({
    children,
}: {
    children: React.ReactNode;
}) {
    return (
        <div className="relative flex justify-center item-start w-[1200px] m-auto">
            <div className="sticky top-0 flex mx-4 max-w-[200px]">MENU</div>
            {children}
            <div className="sticky top-0 flex w-full max-w-[320px]">BUSCA</div>
        </div>
    );
}
